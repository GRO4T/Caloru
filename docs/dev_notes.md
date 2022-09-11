### GitHub Actions secret masking
https://docs.github.com/en/actions/using-workflows/workflow-commands-for-github-actions
```
echo "::add-mask::${{ secrets.SECRET_URL }}" 
```