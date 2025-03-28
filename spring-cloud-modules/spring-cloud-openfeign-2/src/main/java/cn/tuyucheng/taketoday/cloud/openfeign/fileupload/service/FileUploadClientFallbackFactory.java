package cn.tuyucheng.taketoday.cloud.openfeign.fileupload.service;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import cn.tuyucheng.taketoday.cloud.openfeign.exception.BadRequestException;
import cn.tuyucheng.taketoday.cloud.openfeign.exception.NotFoundException;

@Component
public class FileUploadClientFallbackFactory implements FallbackFactory<FileUploadClientWithFallbackFactory> {
   @Override
   public FileUploadClientWithFallbackFactory create(Throwable cause) {
      return _ -> {
         if (cause instanceof BadRequestException) {
            return "Bad Request!!!";
         }
         if (cause instanceof NotFoundException) {
            return "Not Found!!!";
         }
         if (cause instanceof Exception) {
            return "Exception!!!";
         }
         return "Successfully Uploaded file!!!";
      };
   }
}