# Banka Otomasyonu (Bank Automation)

Java ile geliştirilmiş, **nesne yönelimli programlama (OOP)** prensiplerine dayalı
konsol tabanlı bir **banka otomasyon uygulamasıdır**. Kullanıcı; farklı hesap türleri
açabilir, para yatırıp çekebilir ve hesaplarını listeleyebilir.

> Bu proje bir OOP ders/okul projesidir. Kalıtım (inheritance), soyut sınıf (abstract class)
> ve çok biçimlilik (polymorphism) kavramlarının uygulamalı bir örneğidir.

---

## 🎯 Amaç

- Soyut bir `Account` temel sınıfından türeyen farklı hesap türlerini modellemek
- Her hesap türü için farklı **faiz/kâr (benefit)** ve **para çekme limiti** kurallarını
  nesne yönelimli şekilde uygulamak
- Konsol üzerinden temel bankacılık işlemlerini (hesap açma, yatırma, çekme, listeleme) sunmak

---

## ✨ Özellikler

Menüden seçilebilen işlemler:

| Seçenek | İşlem | Kural |
|---------|-------|-------|
| 1 | Kısa vadeli hesap aç | En az **1000 TL** bakiye gerekir |
| 2 | Uzun vadeli hesap aç | En az **1500 TL** bakiye gerekir |
| 3 | Cari hesap aç | Limit yok |
| 4 | Para yatır | — |
| 5 | Para çek | Hesap türüne göre alt limit |
| 6 | Tüm hesapları listele | — |
| 0 | Çıkış | — |

---

## 🏗️ Sınıf Yapısı (OOP Mimarisi)

```
Account (abstract)
│   - id, balance
│   - deposit(), withdraw(), benefit()  → abstract
│
├── ShortTerm  (Kısa vadeli)  → kâr oranı %0.17, alt limit 1000 TL
├── LongTerm   (Uzun vadeli)  → kâr oranı %0.24, alt limit 1500 TL
└── Current    (Cari)         → kâr yok (benefit = 0)

Bank
│   - accountList : ArrayList<Account>
│   - deposit(), withdraw(), getAccount(), getDaysbetween()

BankaOtomasyonu   → main() : menü döngüsü ve kullanıcı etkileşimi
```

| Dosya | Görevi |
|-------|--------|
| `Account.java` | Soyut temel hesap sınıfı (ortak alanlar + soyut metotlar) |
| `ShortTerm.java` | Kısa vadeli hesap |
| `LongTerm.java` | Uzun vadeli hesap |
| `Current.java` | Cari hesap |
| `Bank.java` | Hesapları tutan ve işlemleri yürüten banka sınıfı |
| `BankaOtomasyonu.java` | Uygulama giriş noktası (`main`) ve konsol menüsü |

---

## 🚀 Derleme ve Çalıştırma

Gereksinim: **JDK 8+**

```bash
# Derle
javac -encoding windows-1254 *.java

# Çalıştır
java bankaotomasyonu.BankaOtomasyonu
```

> Not: Kaynak dosyalardaki Türkçe karakterler **Windows-1254** kodlamasıyla kaydedilmiştir.
> Derlerken `-encoding` parametresini vermezseniz bazı metinler bozuk görünebilir.

---

## 🔧 Bu Sürümde Yapılan Düzenlemeler

- **Derleme hatası düzeltildi:** `Current.java` → `deposit()` metodunda `return getBalance;`
  (metot parantezsiz yazılmış, derlenmiyordu) → `return balance;` olarak düzeltildi.
- **Çıkış hatası düzeltildi:** `BankaOtomasyonu` ana döngüsü, `0` girildiğinde hiç sonlanmıyordu
  (kullanılmayan `condition1` değişkeni set ediliyordu). Artık doğru değişken (`condition`)
  güncellenerek döngü düzgün sonlanıyor.
- **Ölü kod temizlendi:** Kullanılmayan `int count;` değişkeni ve boş `case 7` bloğu kaldırıldı.
- **`.gitignore` eklendi** (`.class`, `/build/`, IDE dosyaları, `.env` vb.).

> Güvenlik taraması sonucu: Bu projede **hiçbir API anahtarı, parola veya gizli bilgi yoktur** —
> yalnızca yerel konsol uygulamasıdır.

---

## ⚠️ Bilinen Sınırlamalar (geliştirilmeye açık)

Bu düzenlemede *davranış değiştirmemek* için dokunulmayan, ama ileride düzeltilmesi önerilen noktalar:

- **`ShortTerm` / `LongTerm` → `benefit()`**: `Bank` referansı (`e1` / `e2`) hiç
  oluşturulmadığı için `getDaysbetween()` çağrısı `NullPointerException` verebilir.
- **Menüde `case 2` (uzun vadeli hesap)** sonunda `break;` yok; bu yüzden akış `case 3`'e
  düşüyor. Araya `break;` eklenmesi önerilir.
- **`withdraw()` metotları** hesaplanan yeni bakiyeyi döndürüyor ancak hesabın bakiyesini
  (`setBalance`) güncellemiyor.

---

## 📄 Lisans

Eğitim amaçlı bir projedir; serbestçe incelenip geliştirilebilir.

## 👤 Geliştirici

**Elif Öksüzali** — [GitHub](https://github.com/elifoksuzali)
