package cn.tuyucheng.taketoday.keycloaksoap;

public class Utility {
   public static String getGetProductDetailsRequest() {
      return """
            <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:key="http://www.tuyucheng.com/springbootsoap/keycloak">
               <soapenv:Header/>
               <soapenv:Body>
                  <key:getProductDetailsRequest>
                     <key:id>1</key:id>
                  </key:getProductDetailsRequest>
               </soapenv:Body>
            </soapenv:Envelope>""";
   }

   public static String getDeleteProductsRequest() {
      return """
            <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:key="http://www.tuyucheng.com/springbootsoap/keycloak">
               <soapenv:Header/>
               <soapenv:Body>
                  <key:deleteProductRequest>
                     <key:id>1</key:id>
                  </key:deleteProductRequest>
               </soapenv:Body>
            </soapenv:Envelope>""";
   }
}