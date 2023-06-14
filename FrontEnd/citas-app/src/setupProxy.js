const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function(app) {
  app.use(
    '/quotes',
    createProxyMiddleware({
      target: 'http://localhost:3333',
      changeOrigin: true,
    })
  );
};
