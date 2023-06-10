# dev mode with watch
dev:
  ./gradlew wasmBrowserDevelopmentRun -t

# build project
build:
   ./gradlew build wasmBrowserDistribution
   cp build/js/packages/kotlin-wasm-browser-example-wasm/kotlin/kotlin-wasm-browser-example-wasm.wasm build/distributions/kotlin-wasm-browser-example-wasm.wasm

# serve with http server
serve: build
   python3 -m http.server -d build/distributions