package cn.tuyucheng.taketoday.springvaultk8s;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.vault.config.EnvironmentVaultConfiguration;

@Configuration
@PropertySource("vault-config-k8s.properties")
@Import(EnvironmentVaultConfiguration.class)
public class VaultConfig {
}