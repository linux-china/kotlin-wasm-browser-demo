Kotlin WebAssembly hello world in a browser
============================================

# Browser

- Google Chrome 120+
- Safari 18.2
- Firefox 128+

# Get started

```bash
./gradlew wasmJsBrowserRun -t
```

# Testing on Google Chrome

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