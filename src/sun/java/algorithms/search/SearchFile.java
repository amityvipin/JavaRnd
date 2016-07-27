package sun.java.algorithms.search;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SearchFile {
	
	static ExecutorService executerService = Executors.newCachedThreadPool();
	
	enum SearchOption{
		FILE,FOLDER,BOTH;
	}
	
	
	static class SearchFolder implements Callable<List<String>>{
		
		File file;
		String pattern;
		SearchOption searchOption;
		ExecutorService executerService;
		public SearchFolder(File file, String pattern, SearchOption searchOption, ExecutorService executerService){
			this.file = file;
			this.pattern = pattern;
			this.searchOption = searchOption;
			this.executerService = executerService;
		}

		@Override
		public List<String> call() throws Exception {
			
			if(file.isDirectory()){
				File files[] = file.listFiles();
				for(File file : files){
					if(!file.isDirectory() && file.getName().matches(pattern))
						System.out.println(file.getAbsolutePath());
					else{
						executerService.submit(new SearchFolder(file,pattern,searchOption,executerService)).get();
					}
				}
				
			}else{
				if(!file.isDirectory() && file.getName().matches(pattern))
					System.out.println(file.getAbsolutePath());
			}
			return null;
		}
		
	}
	
	public static void main(String args[]){
		File file = new File("d:/TestFolder");
		try {
			executerService.submit(new SearchFolder(file,"**/*.wsd",SearchOption.BOTH,executerService)).get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
