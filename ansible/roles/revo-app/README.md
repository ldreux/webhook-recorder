revo-app
========

A role to prepare installation of a new Routing Evolution application

Role Variables
--------------

```
revo_app_dir: "/opt/sr-{{app_name}}/"
debug_port: 6666
jmx_port: 12345
xmx: 1024m
xms: 512m
```

Example Playbook
----------------

```
  - role: revo-app
    app_name: webhook
    xmx: 256m
    xms: 256m
    jmx_port: 18350
    debug_port: 6673
    tags: [webhook-install, install]
```

License
-------

BSD

