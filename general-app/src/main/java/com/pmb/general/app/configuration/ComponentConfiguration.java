package com.pmb.general.app.configuration;

import com.pmb.general.core.CoreConfiguration;
import com.pmb.general.repository.RepositoryConfiguration;
import com.pmb.general.web.WebConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author lvrui
 */
@Configuration
@Import({WebConfiguration.class, RepositoryConfiguration.class, CoreConfiguration.class})
public class ComponentConfiguration {
}
