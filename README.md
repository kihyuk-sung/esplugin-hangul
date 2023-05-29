# ES plugins

## 사용법

1. build.gradle 내에 elasticsearchVersion 를 사용하는 버전에 맞도록 수정한다.
2. `./gradlew bundlePlugin` 실행한다.
3. build/distributions 내에 zip을 이용하여 plugin 설치

`sudo bin/elasticsearch-plugin install file://path/to/esplugin.zip`

## Chosung filter

- 한글 초성 변환 필터

## Jamo filter

- 한글 자모 분리 필터

## 통합테스트 (testcontainers)

`./gradlew yamlRestTest`

## es build tools

ElasticSearch plugin을 개발하려면 사용하는 ElasticSeacrh Version에 맞는 es 버전 및 lucene 버전을 
사용하여 만든 jar와 그 내용을 설명하는 [plugin-descriptor.properties](https://www.elastic.co/guide/en/elasticsearch/plugins/current/plugin-descriptor-file-classic.html)
을 jar와 같이 압축한 zip을 제공해야 한다. ElasticSearch에선 이를 위한 gradle plugin을 제공한다.

이를 사용하여 build.gradle 내 esplugin에 plugin-descriptor.properties 내용을 채울 수 있고, 이후 zip으로 플러그인 만드는 과정을 쉽게 진행 할 수 있다.

## yamlRestTest

ElasticSearch에서 testcontainers를 이용한 통합테스트 환경을 제공한다. 이를 구성하기 위해 elasticsearch.yaml-rest-test 를 사용한다.
다만 단순히 해당 플러그인만 사용하지 않고 build.gradle 내 의존성으로 `yamlRestTestRuntimeOnly 'org.apache.logging.log4j:log4j-core`을 추가해야 한다.

## lucene TokenStream 관련 주의사항

- incrementToken 은 final 이어야 한다.
