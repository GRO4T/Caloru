#!/bin/bash
cd "$(git rev-parse --show-toplevel)"/caloru
docker build -t caloru .
docker run -p 8000:8000 caloru