package sun.java.algorithms;

import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FindTest {
	
	public static class SearchThread implements Runnable{

		private Finder finder;
		private Path path;
		
		public SearchThread(Finder finder, Path path){
			this.finder = finder;
			this.path = path;
		}
		@Override
		public void run() {
			try {
				Files.walkFileTree(path, finder);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	enum SearchOption{
		FILE,FOLDER,BOTH;
	}
	public static class Finder
    extends SimpleFileVisitor<Path> {
		
		private PathMatcher pathMatcher;
		private SearchOption searchOption;
		
		public Finder(String pattern, SearchOption searchOption){
			pathMatcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
			this.searchOption = searchOption;
		}
		
		 public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			        throws IOException
			    {
			 		find(file);
			        return FileVisitResult.CONTINUE;
			    }

		private void find(Path file) {
			boolean isDir = file.toFile().isDirectory();
			if((searchOption == SearchOption.BOTH) || (isDir && searchOption == SearchOption.FOLDER) || (!isDir && searchOption == SearchOption.FILE)){
				Path fileName = file.getFileName();
				if(fileName!=null && pathMatcher.matches(fileName))
					System.out.println(fileName);
			}
		}
		
		 // Invoke the pattern matching
        // method on each directory.
        @Override
        public FileVisitResult preVisitDirectory(Path dir,
                BasicFileAttributes attrs) {
        	
            find(dir);
            return CONTINUE;
        }
        
        @Override
        public FileVisitResult visitFileFailed(Path file,
                IOException exc) {
            System.err.println(exc);
            return CONTINUE;
        }
		
	}
	public static void main(String args[]) throws IOException{
		long startTime = System.currentTimeMillis();
		Path path = Paths.get("d:/TestFolder");
		String pattern = "*.wsd";
		Finder finder = new Finder(pattern,SearchOption.BOTH);
		Files.walkFileTree(path, finder);
		System.out.println(System.currentTimeMillis()-startTime);
		
//		long startTime = System.currentTimeMillis();
//		String pattern = "*.wsd";
//		Finder finder = new Finder(pattern,SearchOption.BOTH);
//		ExecutorService executer = Executors.newCachedThreadPool();
//		File file = new File("d:/TestFolder");
//		File files[] = file.listFiles();
//		for(File temp : files){
//			Path path = Paths.get(temp.getAbsolutePath());
//			executer.submit(new SearchThread(finder,path));
//		}
//		executer.shutdown();
//		try {
//			if(executer.awaitTermination(150, TimeUnit.MILLISECONDS))
//				System.out.println("success");
//			else{
//				System.out.println(System.currentTimeMillis()-startTime);
//				System.exit(0);
//			}
//			
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}

}
