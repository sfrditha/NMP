package com.ubaya.anative

import java.time.Month
import java.util.Calendar.SEPTEMBER

object ScheduleData {
    var schedulesData: Array<Schedule> = arrayOf(
        // Valorant Schedules
        Schedule("Valorant Grand Finale", 12, "October", "Valorant", "Team A", R.drawable.valo, "Galaxy Mall",
            "Pertandingan yang sangat dinantikan oleh para penggemar Valorant. Grand Finale ini akan mempertemukan tim-tim terbaik yang telah berjuang keras selama musim kompetisi. Tim A, yang dikenal dengan strategi agresif dan taktik yang solid, akan berhadapan dengan lawan-lawan tangguh di Galaxy Mall. Arena ini akan dipenuhi dengan aksi cepat, tembakan presisi, dan momen-momen mendebarkan. Siapa yang akan menjadi juara?"),

        Schedule("Valorant Champions League", 18, "November", "Valorant", "Team B", R.drawable.valo, "Supermall Surabaya",
            "Liga Champions Valorant menghadirkan tim-tim terbaik dari seluruh negeri untuk bertarung dalam serangkaian pertandingan intens. Tim B, yang memiliki reputasi sebagai tim yang penuh kejutan, siap untuk menunjukkan kemampuan mereka di panggung besar. Pertandingan akan berlangsung di Supermall Surabaya, sebuah arena yang megah dan ideal untuk kompetisi tingkat tinggi. Penggemar Valorant pasti tidak akan melewatkan pertandingan ini yang penuh dengan momen-momen mendebarkan."),

        Schedule("Valorant All-Star Showdown", 30, "December", "Valorant", "Team C", R.drawable.valo, "City of Tomorrow",
            "Ajang All-Star Showdown Valorant adalah kesempatan langka di mana para bintang Valorant berkumpul untuk sebuah pertandingan eksibisi yang tidak hanya menunjukkan keahlian, tetapi juga hiburan. Team C, yang terdiri dari pemain-pemain berbakat dengan berbagai gaya bermain, akan memamerkan keterampilan mereka dalam sebuah pertunjukan yang penuh dengan kejutan. City of Tomorrow akan menjadi tempat di mana para penggemar bisa menikmati pertandingan yang berbeda dari biasanya."),

        // PUBG Schedules
        Schedule("PUBG Winter Clash", 5, "January", "PUBG", "Team A", R.drawable.pabji, "Pakuwon Mall",
            "Pertarungan di medan bersalju akan menjadi tantangan tersendiri dalam PUBG Winter Clash. Team A, dengan keahlian mereka dalam bertahan dan menyerang, akan menghadapi cuaca dingin dan kondisi medan yang sulit di Pakuwon Mall. Para penggemar PUBG akan disuguhkan aksi taktis yang luar biasa, di mana setiap keputusan bisa menjadi perbedaan antara kemenangan dan kekalahan."),

        Schedule("PUBG Spring Tournament", 12, "March", "PUBG", "Team B", R.drawable.pabji, "Tunjungan Plaza",
            "Turnamen Musim Semi PUBG ini akan menjadi panggung bagi Team B untuk menunjukkan dominasi mereka di antara tim-tim lainnya. Pertandingan akan berlangsung di Tunjungan Plaza, dengan suasana yang penuh semangat dari para penggemar yang hadir. Team B dikenal karena kemampuannya dalam bertahan hidup dan menggunakan lingkungan untuk keunggulan taktis. Siapakah yang akan keluar sebagai pemenang dalam medan pertempuran yang tak terduga ini?"),

        Schedule("PUBG Summer Showdown", 28, "July", "PUBG", "Team C", R.drawable.pabji, "Royal Plaza",
            "Summer Showdown PUBG menghadirkan panasnya musim panas ke medan pertempuran, dan Team C siap untuk bertarung habis-habisan. Dengan suasana Royal Plaza yang memanas, pertandingan ini akan menjadi pertarungan taktis yang menguji kemampuan pemain dalam menavigasi pertempuran dengan cerdas. Para penggemar PUBG akan disuguhkan pertarungan epik dengan aksi cepat dan keputusan mendadak yang menentukan hasil."),

        // Mobile Legends Schedules
        Schedule("Mobile Legend Southeast Asia Cup", 14, "August", "Mobile Legend", "Team A", R.drawable.ml, "Pakuwon Mall",
            "Southeast Asia Cup Mobile Legends adalah ajang paling bergengsi yang mempertemukan tim-tim terbaik dari seluruh Asia Tenggara. Team A, dengan rekam jejak impresif mereka, akan bersaing dengan tim-tim regional lainnya dalam sebuah pertarungan yang sangat kompetitif. Pertandingan ini akan diadakan di Pakuwon Mall, sebuah arena besar yang akan dipenuhi oleh sorak-sorai penonton setia."),

        Schedule("Mobile Legend National League", 22, "September", "Mobile Legend", "Team B", R.drawable.ml, "Galaxy Mall",
            "Liga Nasional Mobile Legends selalu menjadi sorotan bagi para penggemar, dan Team B telah mempersiapkan strategi terbaik mereka untuk menghadapi lawan-lawan tangguh. Dengan pengalaman mereka di turnamen sebelumnya, Team B siap untuk menunjukkan performa terbaik di Galaxy Mall. Pertandingan ini akan penuh dengan aksi cepat, kerja sama tim yang luar biasa, dan serangan-serangan mematikan yang membuat Mobile Legends begitu populer."),

        Schedule("Mobile Legend World Championship", 9, "October", "Mobile Legend", "Team C", R.drawable.ml, "Supermall Surabaya",
            "World Championship Mobile Legends adalah acara puncak dari semua turnamen, di mana tim-tim terbaik dari seluruh dunia bertemu untuk memperebutkan gelar juara dunia. Team C, yang telah menjalani perjalanan panjang melalui berbagai turnamen, kini berada di ambang kemenangan tertinggi. Pertandingan ini akan berlangsung di Supermall Surabaya, di hadapan ribuan penggemar yang mendukung tim-tim favorit mereka. Siapakah yang akan mengangkat trofi dan menjadi juara dunia Mobile Legends?")
    )

}