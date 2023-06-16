module.exports = function override(config, env) {
    // Encuentra la sección 'contentSecurityPolicy' en la configuración de Webpack
    const contentSecurityPolicy = config?.plugins?.find(
      (plugin) => plugin?.options?.policy?.directives
    )?.options?.policy?.directives['script-src'];
  
    // Agrega 'unsafe-eval' a la directiva 'script-src'
    if (contentSecurityPolicy) {
      contentSecurityPolicy.push("'unsafe-eval'");
    }
  
    return config;
  };
  