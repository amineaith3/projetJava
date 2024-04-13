#!/bin/bash

# Check if the commit message is provided as an argument
if [ $# -eq 0 ]; then
    echo "Usage: $0 <commit_message>"
    exit 1
fi

# Store the commit message from the argument
msg="$1"

# Git commands
git add .
git commit -m "$msg"
git push
