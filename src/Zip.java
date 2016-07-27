import java.io.*;
import java.util.zip.*;
public class Zip {
   static final int BUFFER = 2048;
   public static void main (String argv[]) throws Exception {
      FileOutputStream dest = new      FileOutputStream("D:/Important personal/parent1.zip");
    ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
      new Zip().zip(new File("C:/Users/Vipin/Desktop/Parent"), out);
      out.close();
   }
   
   
   void zip(File file, ZipOutputStream zos) throws IOException
   {
       zip(file, file.getName(), zos);
   }

   void zip(File file, String name, ZipOutputStream zos) throws IOException
   {
       if (file.isDirectory())
       {
           File[] files = file.listFiles();
           if (files != null) // always check, in case the folder can't be read
           {
               for (File f: files)
               {
                   String childName = name + "/" + f.getName();
                   zip(f, childName, zos);
               }
           }
           if(files.length == 0){
        	   ZipEntry entry = new ZipEntry(name+"/");
               zos.putNextEntry(entry);
               zos.closeEntry();
           }
       }
       else
       {
    	   BufferedInputStream origin = null;
    	   FileInputStream fi = new FileInputStream(file);
         origin = new BufferedInputStream(fi, BUFFER);
         ZipEntry entry = new ZipEntry(name);
         zos.putNextEntry(entry);
         byte data[] = new byte[BUFFER];
         int count;
         while((count = origin.read(data, 0,
           BUFFER)) != -1) {
        	 zos.write(data, 0, count);
         }
         origin.close();
       }
   }
}