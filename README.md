Kotlin WebAssembly hello world in a browser
============================================

# Install Chrome Canary(unstable)

Install latest Chrome Canary(120+) from https://www.google.com/intl/en_us/chrome/canary/

After install, open `chrome://flags` and enable all `WebAssembly` flags to active `WebAssembly Garbage Collection`.

Kotlin 1.9.20-Beta2 is out!

* ⚠️ Since this version, Kotlin/Wasm uses final opcodes for Wasm GC and TFR* proposals.
* ⚠️ So, it may require updating your wasm environment!

For Chrome, Chromium-based browsers, and Firefox, you need version 119.

# Get started

```bash
./gradlew wasmJsBrowserRun -t
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