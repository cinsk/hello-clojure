# hello-clojure

A Clojure library designed to ... well, that part is up to you.

## Emacs

Open a clojure source file, do `C-c M-j` to open clojure console.

* `C-c M-n` to set the current namespace of REPL to that of the source.  Changing the namespace does not evaluate the contents of the buff
* `C-c C-j` to create REPL buffer
* `C-c C-z` to switch to REPL buffer
* `C-x C-e` to eval last sexp
* `C-c C-v r` to eval the region
* `C-c s d` to launch the documentation (`cider-doc`)

If you add new dependencies, you need to restart the REPL by `M-x cider-restart`.

### paredit-mode

* `C-)` - paredit-forward-slurp-sexp
* `C-}` - paredit-forward-barf-sexp
* `C-(` - paredit-backward-slurp-sexp
* `C-{` - paredit-backward-barf-sexp
* `M-)` - paredit-close-round-and-new-line
* `C-M-n` - paredit-forward-up
* `C-M-u` - paredit-backward-up

* `C-K` - paredit-kill
* `C-D` - paredit-forward-delete
* `M-s` - paredit-splice-sexp

If you want to insert closing parenthese literally at a point, use `C-q CHAR` to insert it.

## Usage

To run, use `lein run -- ARGUMENTS`.

        $ lein run -- -o output hello world
        # output: hello
        # arguments: ["world"]
        hello, world!

To create an uber jar, run `lein uberjar`:

        $ lein uberjar
        $ java -jar target/hello-clojure-0.1.0-SNAPSHOT-standalone.jar -o hello world
        # output: hello
        # arguments: ["world"]
        hello, world!

To create a jar, run `lein jar`.  I do not know how to run with `java`.

## License

Copyright © 2016 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
