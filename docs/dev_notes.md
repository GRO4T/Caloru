### GitHub Actions secret masking
https://docs.github.com/en/actions/using-workflows/workflow-commands-for-github-actions
```
echo "::add-mask::${{ secrets.SECRET_URL }}" 
```
### How to serve static files on Apache mod_wsgi Django deployment
#### (preferred) Serve static files on
#### Serve static files using Apache
1. Add this to Apache's configuration (for Apache 2.4).
```
Alias /static /var/www/caloru/static/

<Directory /var/www/caloru/static/>
    Options +Indexes
    Require all granted
</Directory>
```
2. Add this to Django's settings.py file
```python
STATIC_ROOT = "/var/www/caloru/static/"

STATIC_URL = "static/"
```
This will make static files available at http://<server_address>/static/

NOTE: apache user should be able to access static files directory

Sources: \
https://access.redhat.com/solutions/67298 \
https://docs.djangoproject.com/en/4.1/howto/static-files/ \
https://stackoverflow.com/questions/8687927/difference-between-static-static-url-and-static-root-on-django

### Resources
https://docs.djangoproject.com/en/4.1/howto/deployment/wsgi/modwsgi/#serving-files