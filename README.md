# Mayın Tarlası Oyunu

Bu projede Java ile Mayın Tarlası oyunu tasarladık. Oyunun amacı normal bir mayın tarlası oyunundan farksızdır. Amacımız tarla içerisinde bulunan mayınlara basmadan oyunu bitirmektir.

## Proje Detayları

- **Proje Adı:** Mayın Tarlası Oyunu
- **Programlama Dili:** Java

## Oyun Kuralları

- Oyun tahtası üzerinde rastgele yerleştirilmiş mayınlar bulunmaktadır.
- Oyuncunun amacı, mayına basmadan diğer hücreleri açmaktır.
- Her hücre, açıldığında bir sayı çıkar ve  etrafındaki mayınların sayısını gösterir.
- Eğer bir hücreye tıkladığınızda mayına çarparsanız, oyun biter.

## Kullanılan Metotlar ve Sınıflar

### `MineSweeper` Sınıfı

Bu metod, oyunu hazırlar. Belirtilen satır ve sütun sayısına göre tahtayı oluşturur ve mayınları yerleştirir.

#### `public void playGame()`

Bu metot, oyunu başlatır ve kullanıcının hamlelerini alır. Oyunun akışını kontrol eder ve oyun durumuna göre kazanıldı veya kaybedildi mesajlarını görüntüler.

#### `private void initializeBoard()`

Bu metot, oyun tahtasını başlangıç durumuna getirir. Tüm hücreleri kapalı olarak ayarlar.

#### `private void placeMines()`

Bu metot, oyun tahtasına rastgele mayınlar yerleştirir.

#### `private void printBoard()`

Bu metot, oyun tahtasını ekrana yazdırır.

#### `private void revealBoard()`

Bu metot, oyunun sonunda oyun tahtasının tamamını ekrana yazdırır, tüm mayınları gösterir.

#### `private boolean isValidMove(int row, int col)`

Bu metot, belirli bir hamlenin geçerli olup olmadığını kontrol eder. Verilen satır ve sütun koordinatları tahta sınırları içinde ise `true`, değilse `false` döner.

#### `private void makeMove(int row, int col)`

Bu metot, belirli bir hamleyi yapar. Eğer seçilen hücrede mayın varsa oyunu kaybeder, yoksa etrafındaki mayın sayısını hesaplar ve tahtayı günceller.

#### `private int countMinesNearby(int row, int col)`

Bu metot, belirli bir hücrenin etrafındaki mayın sayısını hesaplar.
