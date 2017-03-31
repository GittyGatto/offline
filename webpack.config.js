/* eslint-env node, es6 */

var path = require('path');
var webpack = require('webpack');

var CompressionPlugin = require('compression-webpack-plugin');
var ExtractTextPlugin = require('extract-text-webpack-plugin');
var ngAnnotatePlugin = require('ng-annotate-webpack-plugin');

const extractCSS = new ExtractTextPlugin('[name].css');

const publicDir = 'src/main/resources/public';

var config = {
  entry: {
    'main': 'main',
  },
  output: {
    path: path.resolve(publicDir, 'static'),
    publicPath: '/static/',
    filename: '[name].js',
    chunkFilename: "[chunkhash].bundle.js"
  },
  devServer: {
    port: 8081,
    contentBase: path.join(publicDir),
    hot: true,
    overlay: true,
    proxy: {
      '/': 'http://localhost:8080'
    },
  },
  resolve: {
    mainFiles: [
      'main',
      'index',
    ],
    modules: [
      path.resolve(__dirname, 'node_modules'),
      path.resolve(__dirname, publicDir),
    ],
    alias: {
    }
  },
  module: {
    rules: [
      {
        test: /\.(png|jpg|jpeg|gif)$/,
        include: [publicDir],
        use: 'url-loader?limit=8192'
      },
      {
        test: /\.(ttf|eot|svg)(\?v=[0-9]\.[0-9]\.[0-9])?$/,
        loader: "file-loader?name=[name].[hash].[ext]"
      },
      {
        test: /\.woff(2)?(\?v=[0-9]\.[0-9]\.[0-9])?$/,
        loader: "url-loader?name=[name].[hash].[ext]&limit=10000&mimetype=application/font-woff"
      },
      {
        test: /\.html$/,
        exclude: /node_modules/,
        use: 'html-loader'
      },
      { // BabelJS
        test: /\.js$/,
        exclude: /(node_modules|vendor)/,
        loader: "babel-loader",
        query: {
          presets: ['es2015'],
          cacheDirectory: true
        }
      },
    // { // ESLint
    //   enforce: "pre",
    //   test: /\.js$/,
    //   exclude: jsLintAndBabelLoaderExcludes,
    //   loader: "eslint-loader",
    //   options: {
    //     emitError: false,
    //     emitWarning: false,
    //     failOnError: false,
    //     cache: true,
    //     quiet: true,
    //     outputReport: {
    //       filePath: './checkstyle.xml',
    //       formatter: require('eslint/lib/formatters/checkstyle')
    //     }
    //   }
    // },
    ],
  },
  plugins: [
    new ngAnnotatePlugin({
      add: true,
    }),
  ],
  stats: {
    assets: true,
    children: false,
    errorDetails: true,
  }
};

var executedJavascript = path.parse(process.argv[1]).base;
var isLiveServer = executedJavascript === 'webpack-dev-server';
console.log('webpack.config, using live-server: ' + isLiveServer);
if (!isLiveServer) {
  config.module.rules.push({
    test: /\.scss$/,
    use: extractCSS.extract({
      fallback: "style-loader",
      use: "css-loader!sass-loader"
    }),
  }, {
    test: /\.css$/,
    use: extractCSS.extract({
      fallback: "style-loader",
      use: "css-loader"
    }),
  });
  config.plugins.push(
    extractCSS,
    new webpack.optimize.UglifyJsPlugin({
      beautify: false,
      mangle: {
        warnings: false,
        screw_ie8: true,
      },
      compress: {
        warnings: false,
        screw_ie8: true,
        sequences: true,
        dead_code: true,
        conditionals: true,
        booleans: true,
        unused: true,
        if_return: true,
        join_vars: true,
      },
      comments: false
    }),
    new CompressionPlugin({
      asset: "[path].gz[query]",
      algorithm: "zopfli",
      test: /\.(js|html|css|woff|woff2|eot|svg)$/,
      threshold: 1024,
      minRatio: 0.9
    })
  );
} else {
  config.devtool = 'cheap-module-eval-source-map';
  config.module.rules.push({
    test: /\.scss$/,
    use: [{
      loader: "style-loader"
    }, {
      loader: "css-loader"
    }, {
      loader: "sass-loader"
    }]
  },
    {
      test: /\.css$/,
      use: [{
        loader: "style-loader"
      }, {
        loader: "css-loader"
      }]
    }
  );
  config.plugins.push(
    new webpack.HotModuleReplacementPlugin()
  );
}

module.exports = config;