Kotlin WebAssembly hello world in a browser
============================================
**Warning : highly experimental status**

This sample leverages Kotlin/Wasm and V8 with its Wasm GC, typed function references and exception handling proposals.


Origin from: https://github.com/vmware-wasmstack/wasm-languages/tree/main/kotlin/browser-hello-world

# Install Chrome Canary(unstable)

Install Chrome Canary from https://www.google.com/intl/en_us/chrome/canary/

After install, please execute following command to start Chrome Canary

```bash
/Applications/Google\ Chrome\ Canary.app/Contents/MacOS/Google\ Chrome\ Canary --js-flags="--experimental-wasm-gc --experimental-wasm-typed-funcref --experimental-wasm-eh" &
```

# Build project

```bash
./gradlew wasmBrowserDistribution
cp build/js/packages/wasm-example-wasm/kotlin/wasm-example-wasm.wasm build/distributions/wasm-example-wasm.wasm
cp build/js/packages/wasm-example-wasm/kotlin/wasm-example-wasm.wasm build/distributions/wasm-example-wasm.wat
```

# Start web server 

```bash
python3 -m http.server -d build/distributions
```

# Testing on Google Canary

Visit http://localhost:8000/index.html

You will see `Hello World!` on page. Kotlin WebAssembly code as following:

```koltin
fun main() {
    val p = document.createElement("p")
    p.innerHTML = "Hello World!"
    document.body.appendChild(p)
}
```
