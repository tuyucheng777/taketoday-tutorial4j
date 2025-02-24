package cn.tuyucheng.taketoday.tutorials.passkey.repository;

import cn.tuyucheng.taketoday.tutorials.passkey.domain.PasskeyUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.webauthn.api.Bytes;
import org.springframework.security.web.webauthn.api.ImmutablePublicKeyCredentialUserEntity;
import org.springframework.security.web.webauthn.api.PublicKeyCredentialUserEntity;
import org.springframework.security.web.webauthn.management.PublicKeyCredentialUserEntityRepository;

@Slf4j
@RequiredArgsConstructor
public class DbPublicKeyCredentialUserEntityRepository implements PublicKeyCredentialUserEntityRepository {

   private final PasskeyUserRepository userRepository;

   @Override
   public PublicKeyCredentialUserEntity findById(Bytes id) {
      LOGGER.info("findById: id={}", id.toBase64UrlString());
      var externalId = id.toBase64UrlString();
      return userRepository.findByExternalId(externalId)
            .map(DbPublicKeyCredentialUserEntityRepository::mapToUserEntity)
            .orElse(null);
   }

   @Override
   public PublicKeyCredentialUserEntity findByUsername(String username) {
      LOGGER.info("findByUsername: username={}", username);
      return userRepository.findByName(username)
            .map(DbPublicKeyCredentialUserEntityRepository::mapToUserEntity)
            .orElse(null);
   }

   @Override
   public void save(PublicKeyCredentialUserEntity userEntity) {
      LOGGER.info("save: username={}, externalId={}", userEntity.getName(), userEntity.getId().toBase64UrlString());
      var entity = userRepository.findByExternalId(userEntity.getId().toBase64UrlString())
            .orElse(new PasskeyUser());

      entity.setExternalId(userEntity.getId().toBase64UrlString());
      entity.setName(userEntity.getName());
      entity.setDisplayName(userEntity.getDisplayName());

      userRepository.save(entity);
   }

   @Override
   public void delete(Bytes id) {
      LOGGER.info("delete: id={}", id.toBase64UrlString());
      userRepository.findByExternalId(id.toBase64UrlString())
            .ifPresent(userRepository::delete);
   }

   private static PublicKeyCredentialUserEntity mapToUserEntity(PasskeyUser user) {
      return ImmutablePublicKeyCredentialUserEntity.builder()
            .id(Bytes.fromBase64(user.getExternalId()))
            .name(user.getName())
            .displayName(user.getDisplayName())
            .build();
   }
}