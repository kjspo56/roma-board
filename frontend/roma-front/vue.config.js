const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})

// const target = 'http://localhost:9096'
// module.exports = {
//   devServer: {
//     port: 9096,
//     proxy: {
//       '/api': {
//         target,
//         changeOrigin: true
//       }
//     }
//   }
// }