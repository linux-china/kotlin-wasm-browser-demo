# dev mode with watch
dev:
  ./gradlew wasmBrowserDevelopmentRun -t

# build project
build:
   ./gradlew build wasmJsBrowserDistribution

# serve with http server
serve: build
   python3 -m http.server -d build/js/packages/kotlin-wasm-browser-example-wasm/kotlin