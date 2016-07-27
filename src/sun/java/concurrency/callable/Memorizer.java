package sun.java.concurrency.callable;

import java.util.concurrent.*;

interface Computable<A,V>{
	V compute(A arg) throws InterruptedException;
}
public class Memorizer<A,V> implements Computable<A,V> {
	
	private final ConcurrentHashMap<A,Future<V>> cache = new ConcurrentHashMap<A,Future<V>>();
	private final Computable<A,V> computable;
	public Memorizer(Computable<A,V> computable){
		this.computable = computable;
	}
	
	@Override
	public V compute(final A arg) throws InterruptedException {
		
		while(true){
			Future<V> f = cache.get(arg);
			if(f==null){
				Callable<V> eval = new Callable<V>(){

					@Override
					public V call() throws Exception {
						return computable.compute(arg);
					}
				};
				FutureTask<V> ft = new FutureTask<V>(eval);
				f =cache.putIfAbsent(arg, ft);
				if(f==null){
					f = ft;
					ft.run();
				}
			}
			try{
				return f.get();
			}catch(CancellationException ce){
				cache.remove(arg);
			}catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
