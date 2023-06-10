Kotlin WebAssembly hello world in a browser
============================================
**Warning : highly experimental status**

This sample leverages Kotlin/Wasm and V8 with its Wasm GC, typed function references and exception handling proposals.

Origin from: https://github.com/vmware-wasmstack/wasm-languages/tree/main/kotlin/browser-hello-world

# Install Chrome Canary(unstable)

Install latest Chrome Canary(112+) from https://www.google.com/intl/en_us/chrome/canary/

After install, open `chrome://flags` and enable all `WebAssembly` flags to active `WebAssembly Garbage Collection`.

# Get started 

```bash
./gradlew wasmBrowserDevelopmentRun -t
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
          
# References
                                                          
* Kotlinx DOM API: https://kotlinlang.org/api/latest/jvm/stdlib/kotlinx.dom/
* Kotlinx Browser API: https://kotlinlang.org/api/latest/jvm/stdlib/kotlinx.browser/
* Introducing Kotlin/Wasm: https://seb.deleuze.fr/introducing-kotlin-wasm/
* Kotlin goes WebAssembly!: https://www.youtube.com/watch?v=oIbX7nrSTPQ