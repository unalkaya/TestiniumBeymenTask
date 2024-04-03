# BeymenTest Projesi

Bu proje, Beymen web sitesinin bazı temel test senaryolarını içeren bir Selenium otomasyon test projesidir. Proje, Java programlama dili ve Selenium WebDriver kütüphanesi kullanılarak yazılmıştır. Test senaryoları, JUnit test çerçevesi kullanılarak uygulanmıştır.

## Proje Yapısı

Proje, aşağıdaki paketlerden oluşmaktadır:

- `org.example`: Proje ana paketi
- `pages`: Sayfa nesnelerinin (Page Objects) tanımlandığı paket
- `utils`: Yardımcı sınıfların bulunduğu paket

## Nasıl Çalıştırılır

Proje, bir Maven projesi olarak yapılandırılmıştır. Projenin çalıştırılabilmesi için bilgisayarınızda Java ve Maven'in yüklü olması gerekmektedir. Proje dosyalarını bilgisayarınıza indirdikten sonra, proje dizininde terminal veya komut istemcisini açın ve aşağıdaki komutu çalıştırarak testleri çalıştırabilirsiniz:


## Gereksinimler

Projenin çalıştırılabilmesi için aşağıdaki bileşenlere ihtiyaç vardır:

- Java
- Maven
- Selenium WebDriver
- JUnit

- Gerekli bağımlılıklar, `pom.xml` dosyasında belirtilmiştir.
## Test Sınıfları

### BaseTest

`BaseTest` sınıfı, tüm test sınıflarının temel sınıfıdır. Bu sınıf, testlerin ortak özelliklerini içerir ve testlerin çalışma ortamını yapılandırmak için kullanılır.

### BeymenTest

`BeymenTest` sınıfı, Beymen web sitesinin test senaryolarını içerir. Bu sınıf, Beymen web sitesindeki çeşitli işlevleri test etmek için kullanılır.

