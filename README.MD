# WebHook Recorder

The `webhook-recorder` is a java application that record post http requests into files.

## Compilation

```
mvn clean install
```

## Execution

```
java -Dwebhook.out-folder-path=~/Temp -Dserver.port=9090 -jar target/webhook-recorder.jar
```

## Exemple

```
echo '{"text": "Hello **world**!"}' | curl -d @- -X POST http://localhost:8080/record --header "Content-Type:application/json"
```

## Configuration

Set `webhook.out-folder-path` variable to define the output folder path.

## License
This buildpack is released under version 2.0 of the [Apache License][].

[Apache License]: http://www.apache.org/licenses/LICENSE-2.0