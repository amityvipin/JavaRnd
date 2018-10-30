
public class ReflectionTest {
   public static void main(String[] args) throws Exception {
       Object object = new Object();

       int loops = 100000;

       long start = System.currentTimeMillis();
       Object s;
       for (int i = 0; i < loops; i++) {
           s = object.toString();
       }
       long regularCalls = System.currentTimeMillis() - start;

       start = System.currentTimeMillis();
       Class<Object> c = Object.class;
       java.lang.reflect.Method method = c.getMethod("toString");
       for (int i = 0; i < loops; i++) {
           s = method.invoke(object);
       }

       long reflectiveCalls = System.currentTimeMillis() - start;
       start = System.currentTimeMillis();
       for (int i = 0; i < loops; i++) {
           s = method.invoke(object);
       }

       long reflectiveLookup = System.currentTimeMillis() - start;

       System.out.println(loops + " regular method calls:" + regularCalls
               + " milliseconds.");

       System.out.println(loops + " reflective method calls without lookup:"
               + reflectiveCalls+ " milliseconds.");

       System.out.println(loops + " reflective method calls with lookup:"
               + reflectiveLookup + " milliseconds.");

   }
}