# grails-soft-delete
Provides Grails domain classes support for soft (or logical) deletes.

### WARNING
This code is experimental. I can't garantee it will work, but I will improve it over time.

### How to install
Slap the following code into `build.gradle`, dependencies part:

`compile 'org.grails.plugins:soft-delete:0.3'`

Alternatively you have to clone the repository, build the jar file and put it on a libs folder inside your application.

### How it works
The plugin enhances all the domain classes using traits, overriding the common GORM methods.

### What is supported
The following methods are supported:

- delete() (obvious, isn't it)
- get()
- load()
- getAll()
- list()
- first()
- last()
- findBy...(), findAllBy...(), countBy...()
- createCriteria()

### What is not
Well, the world isn't perfect

- All methods that use string query
- find() (which uses closures)