build:
   ./gradlew build wasmBrowserDistribution
   cp build/js/packages/kotlin-wasm-browser-example-wasm/kotlin/kotlin-wasm-browser-example-wasm.wasm build/distributions/kotlin-wasm-browser-example-wasm.wasm

server: build
   python3 -m http.server -d build/distributions