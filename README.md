# ES plugins

## 사용법

1. build.gradle 내에 elasticsearchVersion 를 사용하는 버전에 맞도록 수정한다.
2. `./gradlew bundlePlugin` 실행한다.
3. build/distributions 내에 zip을 이용하여 plugin 설치

`sudo bin/elasticsearch-plugin install file://path/to/esplugin.zip`
