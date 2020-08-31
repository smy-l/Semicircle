package pkg2;

public class SimpleObjFactory {
  public static Object getObject(String s){
    if(s.equals("pkg2.B")){
      return new B();
    }if(s.equals("pkg2.C")) {
      return new C();
    }
    return null;
  }

}
