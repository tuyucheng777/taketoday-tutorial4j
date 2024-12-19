package cn.tuyucheng.taketoday.junitvsmockito;

public class NonInstantiableClassForMockito {

   public String nonTestableComponent() {
      return "some result";
   }
}