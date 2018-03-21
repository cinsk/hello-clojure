#!/bin/bash

LEIN=$HOME/bin/lein

if [ ! -x "$LEIN" ]; then
    mkdir -p "$(dirname "$LEIN")"
    curl -L -o "$LEIN" "https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein"
    chmod +x "$LEIN"
fi
