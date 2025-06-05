import duadimen.*;
import tigadimen.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;

public class MainGeometryApp extends JFrame {

    private JComboBox<String> shapeComboBox;
    private JPanel inputPanel;
    private JTextField[] inputFields;
    private JLabel resultLabel;
    private JButton calculateButton;

    public MainGeometryApp() {
        setTitle("Kalkulator Bangun Datar & Ruang");
        setSize(700, 500); // Increased size to accommodate more inputs
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        initComponents();
        addListeners();
        setupLayout();
    }

    private void initComponents() {
        shapeComboBox = new JComboBox<>(new String[]{
                "duadimen.Persegi Panjang", "duadimen.Persegi", "duadimen.Segitiga", "duadimen.Trapesium",
                "duadimen.Lingkaran", "tigadimen.Tabung", "tigadimen.Bola", "Tembereng tigadimen.Bola", "Tembereng duadimen.Lingkaran",
                "Belah Ketupat", "Prisma Belah Ketupat", "Layang-Layang", "Prisma Layang-Layang",
                // New shapes from previous request
                "Jajar Genjang", "Juring tigadimen.Bola", "Juring duadimen.Lingkaran", "tigadimen.Kerucut", "tigadimen.Kerucut Terpancung",
                "tigadimen.Kubus", "Limas Belah Ketupat", "Limas Jajar Genjang", "Limas Layang-Layang", "Limas duadimen.Persegi",
                // Newly added shapes
                "Cincin tigadimen.Bola", "Limas duadimen.Persegi Panjang", "Limas duadimen.Segitiga", "Limas duadimen.Trapesium",
                "Prisma Jajar Genjang", "Prisma duadimen.Segitiga", "Prisma duadimen.Trapesium"
        });
        inputPanel = new JPanel(new GridLayout(0, 2, 10, 5)); // 0 rows, 2 columns
        resultLabel = new JLabel("Hasil: ");
        calculateButton = new JButton("Hitung");
    }

    private void addListeners() {
        shapeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateInputPanel();
            }
        });

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performCalculation();
            }
        });
    }

    private void setupLayout() {
        setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(new JLabel("Pilih Bangun:"));
        topPanel.add(shapeComboBox);
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        centerPanel.add(new JScrollPane(inputPanel), BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        bottomPanel.add(resultLabel, BorderLayout.NORTH);
        bottomPanel.add(calculateButton, BorderLayout.SOUTH);
        add(bottomPanel, BorderLayout.SOUTH);

        // Initial update of input panel based on default selection
        updateInputPanel();
    }

    private void updateInputPanel() {
        inputPanel.removeAll();
        String selectedShape = (String) shapeComboBox.getSelectedItem();
        String[] labels = {};

        switch (selectedShape) {
            case "duadimen.Persegi Panjang":
                labels = new String[]{"Panjang:", "Lebar:"};
                break;
            case "duadimen.Persegi":
                labels = new String[]{"Sisi:"};
                break;
            case "duadimen.Segitiga":
                labels = new String[]{"Alas (Luas):", "Tinggi (Luas):", "Sisi 1 (Keliling):", "Sisi 2 (Keliling):", "Sisi 3 (Keliling):"};
                break;
            case "duadimen.Trapesium":
                labels = new String[]{"Sisi Atas:", "Sisi Bawah:", "Sisi Miring 1:", "Sisi Miring 2:", "Tinggi:"};
                break;
            case "duadimen.Lingkaran":
                labels = new String[]{"Radius:"};
                break;
            case "tigadimen.Tabung":
                labels = new String[]{"Radius:", "Tinggi tigadimen.Tabung:"};
                break;
            case "tigadimen.Bola":
                labels = new String[]{"Radius:"};
                break;
            case "Tembereng tigadimen.Bola":
                labels = new String[]{"Radius tigadimen.Bola:", "Tinggi Tembereng:"};
                break;
            case "Tembereng duadimen.Lingkaran":
                labels = new String[]{"Radius duadimen.Lingkaran:", "Sudut Pusat (Radian):"};
                break;
            case "Belah Ketupat":
                labels = new String[]{"Diagonal 1:", "Diagonal 2:", "Sisi (untuk Keliling):"};
                break;
            case "Prisma Belah Ketupat":
                labels = new String[]{"Diagonal 1 (Alas):", "Diagonal 2 (Alas):", "Sisi Alas (untuk keliling alas):", "Tinggi Prisma:"};
                break;
            case "Layang-Layang":
                labels = new String[]{"Diagonal Horizontal:", "Diagonal Vertikal:", "Sisi A (untuk Keliling):", "Sisi B (untuk Keliling):"};
                break;
            case "Prisma Layang-Layang":
                labels = new String[]{"Diagonal Horizontal (Alas):", "Diagonal Vertikal (Alas):", "Sisi A Alas (untuk keliling alas):", "Sisi B Alas (untuk keliling alas):", "Tinggi Prisma:"};
                break;
            // New Shapes' Labels (from previous request)
            case "Jajar Genjang":
                labels = new String[]{"Alas:", "Tinggi:", "Sisi Miring (untuk Keliling):"};
                break;
            case "Juring tigadimen.Bola":
                labels = new String[]{"Radius tigadimen.Bola:", "Tinggi Tembereng (h_cap):"}; // Using h_cap for consistency
                break;
            case "Juring duadimen.Lingkaran":
                labels = new String[]{"Radius duadimen.Lingkaran:", "Sudut Pusat (Radian):"};
                break;
            case "tigadimen.Kerucut":
                labels = new String[]{"Radius Alas:", "Tinggi tigadimen.Kerucut:", "Sisi Miring (optional, jika sudah ada R & T, Tdk perlu):"};
                break;
            case "tigadimen.Kerucut Terpancung":
                labels = new String[]{"Radius Atas:", "Radius Bawah:", "Tinggi Terpancung:", "Sisi Miring (optional):"};
                break;
            case "tigadimen.Kubus":
                labels = new String[]{"Sisi:"};
                break;
            case "Limas Belah Ketupat":
                labels = new String[]{"Diagonal 1 (Alas):", "Diagonal 2 (Alas):", "Sisi Alas (untuk keliling alas):", "Tinggi Limas:"};
                break;
            case "Limas Jajar Genjang":
                labels = new String[]{"Alas (Alas):", "Tinggi (Alas):", "Sisi Miring (Alas, untuk keliling):", "Tinggi Limas:"};
                break;
            case "Limas Layang-Layang":
                labels = new String[]{"Diagonal Horizontal (Alas):", "Diagonal Vertikal (Alas):", "Sisi A Alas (untuk keliling alas):", "Sisi B Alas (untuk keliling alas):", "Tinggi Limas:"};
                break;
            case "Limas duadimen.Persegi":
                labels = new String[]{"Sisi Alas:", "Tinggi Limas:"};
                break;
            // Newly added shapes' labels
            case "Cincin tigadimen.Bola":
                labels = new String[]{"Radius Dalam:", "Radius Luar:"};
                break;
            case "Limas duadimen.Persegi Panjang":
                labels = new String[]{"Panjang Alas:", "Lebar Alas:", "Tinggi Limas:"};
                break;
            case "Limas duadimen.Segitiga":
                labels = new String[]{"Alas duadimen.Segitiga Alas:", "Tinggi duadimen.Segitiga Alas:", "Sisi 1 Alas (Keliling):", "Sisi 2 Alas (Keliling):", "Sisi 3 Alas (Keliling):", "Tinggi Limas:"};
                break;
            case "Limas duadimen.Trapesium":
                labels = new String[]{"Sisi Atas Alas:", "Sisi Bawah Alas:", "Tinggi duadimen.Trapesium Alas:", "Sisi Miring 1 Alas (Keliling):", "Sisi Miring 2 Alas (Keliling):", "Tinggi Limas:"};
                break;
            case "Prisma Jajar Genjang":
                labels = new String[]{"Alas Jajar Genjang:", "Tinggi Jajar Genjang Alas:", "Sisi Miring Alas:", "Tinggi Prisma:"};
                break;
            case "Prisma duadimen.Segitiga":
                labels = new String[]{"Alas duadimen.Segitiga Alas:", "Tinggi duadimen.Segitiga Alas:", "Sisi 1 Alas (Keliling):", "Sisi 2 Alas (Keliling):", "Sisi 3 Alas (Keliling):", "Tinggi Prisma:"};
                break;
            case "Prisma duadimen.Trapesium":
                labels = new String[]{"Sisi Atas Alas:", "Sisi Bawah Alas:", "Tinggi duadimen.Trapesium Alas:", "Sisi Miring 1 Alas:", "Sisi Miring 2 Alas:", "Tinggi Prisma:"};
                break;
        }

        inputFields = new JTextField[labels.length];
        for (int i = 0; i < labels.length; i++) {
            inputPanel.add(new JLabel(labels[i]));
            inputFields[i] = new JTextField(10);
            if (selectedShape.startsWith("Class")) {
                inputFields[i].setEditable(false); // Disable input for generic classes
            }
            inputPanel.add(inputFields[i]);
        }
        inputPanel.revalidate();
        inputPanel.repaint();
        resultLabel.setText("Hasil: "); // Clear previous results
    }

    private void performCalculation() {
        String selectedShape = (String) shapeComboBox.getSelectedItem();
        Double[] inputs = new Double[inputFields.length];
        boolean validInput = true;

        for (int i = 0; i < inputFields.length; i++) {
            // For generic classes, inputs are not relevant
            if (selectedShape.startsWith("Class")) {
                inputs[i] = 0.0; // Dummy value, won't be used
                continue;
            }

            try {
                // Allow empty fields for optional parameters (e.g., sides for triangle if calculating area)
                if (!inputFields[i].getText().trim().isEmpty()) {
                    inputs[i] = Double.parseDouble(inputFields[i].getText());
                } else {
                    inputs[i] = null; // Mark as null if empty
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Input tidak valid. Harap masukkan angka.", "Error Input", JOptionPane.ERROR_MESSAGE);
                validInput = false;
                break;
            }
        }

        if (validInput) {
            // Use SwingWorker for background calculation (multithreading)
            new CalculationWorker(selectedShape, inputs).execute();
        }
    }

    // Inner class for SwingWorker
    private class CalculationWorker extends SwingWorker<String, Void> {
        private String shape;
        private Double[] params;

        public CalculationWorker(String shape, Double[] params) {
            this.shape = shape;
            this.params = params;
        }

        @Override
        protected String doInBackground() {
            // Perform the calculation in a background thread
            StringBuilder result = new StringBuilder("Hasil: ");
            try {
                switch (shape) {
                    case "duadimen.Persegi Panjang":
                        PersegiPanjang pp = new PersegiPanjang();
                        pp.setPanjang(params[0]);
                        pp.setLebar(params[1]);
                        result.append("Luas = ").append(String.format("%.2f", pp.hitungLuas())).append(", ");
                        result.append("Keliling = ").append(String.format("%.2f", pp.hitungKeliling()));
                        break;
                    case "duadimen.Persegi":
                        Persegi p = new Persegi();
                        p.setSisi(params[0]);
                        result.append("Luas = ").append(String.format("%.2f", p.hitungLuas())).append(", ");
                        result.append("Keliling = ").append(String.format("%.2f", p.hitungKeliling()));
                        break;
                    case "duadimen.Segitiga":
                        Segitiga s = new Segitiga(); // Instantiated here
                        // Try to calculate area if alas and tinggi are provided
                        try {
                            s.setAlas(params[0]);
                            s.setTinggi(params[1]);
                            result.append("Luas = ").append(String.format("%.2f", s.hitungLuas()));
                        } catch (IllegalArgumentException | IllegalStateException e) {
                            result.append("Luas: ").append(e.getMessage());
                        }
                        result.append(", ");
                        // Try to calculate keliling if 3 sides are provided
                        try {
                            s.setSisi1(params[2]);
                            s.setSisi2(params[3]);
                            s.setSisi3(params[4]);
                            result.append("Keliling = ").append(String.format("%.2f", s.hitungKeliling()));
                        } catch (IllegalArgumentException | IllegalStateException e) {
                            result.append("Keliling: ").append(e.getMessage());
                        }
                        break;
                    case "duadimen.Trapesium":
                        Trapesium t = new Trapesium(); // Instantiated here
                        try {
                            t.setSisiAtas(params[0]);
                            t.setSisiBawah(params[1]);
                            t.setTinggi(params[4]);
                            result.append("Luas = ").append(String.format("%.2f", t.hitungLuas()));
                        } catch (IllegalArgumentException | IllegalStateException e) {
                            result.append("Luas: ").append(e.getMessage());
                        }
                        result.append(", ");
                        try {
                            t.setSisiMiring1(params[2]);
                            t.setSisiMiring2(params[3]);
                            // Reuse already set sides for keliling calculation
                            if (t.getSisiAtas() == null) t.setSisiAtas(params[0]); // Ensure base sides are set
                            if (t.getSisiBawah() == null) t.setSisiBawah(params[1]);
                            result.append("Keliling = ").append(String.format("%.2f", t.hitungKeliling()));
                        } catch (IllegalArgumentException | IllegalStateException e) {
                            result.append("Keliling: ").append(e.getMessage());
                        }
                        break;
                    case "duadimen.Lingkaran":
                        Lingkaran l = new Lingkaran();
                        l.setRadius(params[0]);
                        result.append("Luas = ").append(String.format("%.2f", l.hitungLuas())).append(", ");
                        result.append("Keliling = ").append(String.format("%.2f", l.hitungKeliling()));
                        break;
                    case "tigadimen.Tabung":
                        Tabung tab = new Tabung(); // Instantiated here
                        tab.setRadius(params[0]);
                        tab.setTinggiTabung(params[1]);
                        result.append("Volume = ").append(String.format("%.2f", tab.hitungVolume())).append(", ");
                        result.append("Luas Permukaan = ").append(String.format("%.2f", tab.hitungLuasPermukaan()));
                        break;
                    case "tigadimen.Bola":
                        Bola b = new Bola();
                        b.setRadius(params[0]);
                        result.append("Volume = ").append(String.format("%.2f", b.hitungKelilingAtauVolume())).append(", ");
                        result.append("Luas Permukaan = ").append(String.format("%.2f", b.hitungLuas()));
                        break;
                    case "Tembereng tigadimen.Bola":
                        TemberengBola tb = new TemberengBola(); // Instantiated here
                        tb.setRadius(params[0]);
                        tb.setTinggiTembereng(params[1]);
                        result.append("Volume Tembereng = ").append(String.format("%.2f", tb.hitungVolumeTembereng())).append(", ");
                        result.append("Luas Permukaan Tembereng = ").append(String.format("%.2f", tb.hitungLuasPermukaanTembereng()));
                        break;
                    case "Tembereng duadimen.Lingkaran":
                        TemberengLingkaran tl = new TemberengLingkaran(); // Instantiated here
                        tl.setRadius(params[0]);
                        tl.setSudutPusatRadian(params[1]);
                        result.append("Luas Tembereng = ").append(String.format("%.2f", tl.hitungLuasTembereng())).append(", ");
                        result.append("Keliling Tembereng = ").append(String.format("%.2f", tl.hitungKelilingTembereng()));
                        break;
                    case "Belah Ketupat":
                        BelahKetupat bk = new BelahKetupat();
                        try {
                            if (params[0] != null && params[1] != null) {
                                bk.setDiagonal1(params[0]);
                                bk.setDiagonal2(params[1]);
                                result.append("Luas = ").append(String.format("%.2f", bk.hitungLuas()));
                            } else {
                                result.append("Luas: Diagonal tidak lengkap.");
                            }
                        } catch (IllegalArgumentException | IllegalStateException e) {
                            result.append("Luas: ").append(e.getMessage());
                        }
                        result.append(", ");
                        try {
                            if (params[2] != null) {
                                bk.setSisi(params[2]);
                                result.append("Keliling = ").append(String.format("%.2f", bk.hitungKeliling()));
                            } else {
                                result.append("Keliling: Sisi tidak lengkap.");
                            }
                        } catch (IllegalArgumentException | IllegalStateException e) {
                            result.append("Keliling: ").append(e.getMessage());
                        }
                        break;
                    case "Prisma Belah Ketupat":
                        PrismaBelahKetupat pbk = new PrismaBelahKetupat(); // Instantiated here
                        pbk.setDiagonal1(params[0]);
                        pbk.setDiagonal2(params[1]);
                        pbk.setSisi(params[2]); // For base perimeter calc
                        pbk.setTinggi3D(params[3]);
                        result.append("Volume = ").append(String.format("%.2f", pbk.hitungVolume())).append(", ");
                        result.append("Luas Permukaan = ").append(String.format("%.2f", pbk.hitungLuasPermukaan()));
                        break;
                    case "Layang-Layang":
                        LayangLayang ll = new LayangLayang();
                        try {
                            if (params[0] != null && params[1] != null) {
                                ll.setDiagonalHorizontal(params[0]);
                                ll.setDiagonalVertikal(params[1]);
                                result.append("Luas = ").append(String.format("%.2f", ll.hitungLuas()));
                            } else {
                                result.append("Luas: Diagonal tidak lengkap.");
                            }
                        } catch (IllegalArgumentException | IllegalStateException e) {
                            result.append("Luas: ").append(e.getMessage());
                        }
                        result.append(", ");
                        try {
                            if (params[2] != null && params[3] != null) {
                                ll.setSisiA(params[2]);
                                ll.setSisiB(params[3]);
                                result.append("Keliling = ").append(String.format("%.2f", ll.hitungKeliling()));
                            } else {
                                result.append("Keliling: Sisi tidak lengkap.");
                            }
                        } catch (IllegalArgumentException | IllegalStateException e) {
                            result.append("Keliling: ").append(e.getMessage());
                        }
                        break;
                    case "Prisma Layang-Layang":
                        PrismaLayangLayang pll = new PrismaLayangLayang(); // Instantiated here
                        pll.setDiagonalHorizontal(params[0]);
                        pll.setDiagonalVertikal(params[1]);
                        pll.setSisiA(params[2]); // For base perimeter calc
                        pll.setSisiB(params[3]); // For base perimeter calc
                        pll.setTinggiPLL(params[4]);
                        result.append("Volume = ").append(String.format("%.2f", pll.hitungVolume())).append(", ");
                        result.append("Luas Permukaan = ").append(String.format("%.2f", pll.hitungLuasPermukaan()));
                        break;
                    // New Shapes' Calculations (from previous request)
                    case "Jajar Genjang":
                        JajarGenjang jg = new JajarGenjang();
                        try {
                            if (params[0] != null && params[1] != null) {
                                jg.setAlas(params[0]);
                                jg.setTinggi(params[1]);
                                result.append("Luas = ").append(String.format("%.2f", jg.hitungLuas()));
                            } else {
                                result.append("Luas: Alas atau Tinggi tidak lengkap.");
                            }
                        } catch (IllegalArgumentException | IllegalStateException e) {
                            result.append("Luas: ").append(e.getMessage());
                        }
                        result.append(", ");
                        try {
                            if (params[0] != null && params[2] != null) { // Alas and Sisi Miring
                                jg.setAlas(params[0]);
                                jg.setSisiMiring(params[2]);
                                result.append("Keliling = ").append(String.format("%.2f", jg.hitungKeliling()));
                            } else {
                                result.append("Keliling: Alas atau Sisi Miring tidak lengkap.");
                            }
                        } catch (IllegalArgumentException | IllegalStateException e) {
                            result.append("Keliling: ").append(e.getMessage());
                        }
                        break;
                    case "Juring tigadimen.Bola":
                        JuringBola jb = new JuringBola();
                        jb.setRadius(params[0]);
                        jb.setTinggiKerucutBagianDalam(params[1]);
                        result.append("Volume = ").append(String.format("%.2f", jb.hitungVolumeJuring())).append(", ");
                        result.append("Luas Permukaan = ").append(String.format("%.2f", jb.hitungLuasPermukaanJuring()));
                        break;
                    case "Juring duadimen.Lingkaran":
                        JuringLingkaran jl = new JuringLingkaran();
                        jl.setRadius(params[0]);
                        jl.setSudutPusatRadian(params[1]); // Assuming input is always in Radians for simplicity
                        result.append("Luas = ").append(String.format("%.2f", jl.hitungLuasJuring())).append(", ");
                        result.append("Keliling = ").append(String.format("%.2f", jl.hitungKeliling()));
                        break;
                    case "tigadimen.Kerucut":
                        Kerucut kerucut = new Kerucut();
                        kerucut.setRadius(params[0]);
                        // Prioritize height if given, otherwise use slant height to derive height
                        if (params[1] != null) {
                            kerucut.setTinggiKerucut(params[1]);
                        } else if (params[2] != null) {
                            kerucut.setSisiMiring(params[2]);
                        } else {
                            throw new IllegalStateException("Tinggi atau Sisi Miring kerucut harus diatur.");
                        }
                        result.append("Volume = ").append(String.format("%.2f", kerucut.hitungVolumeKerucut())).append(", ");
                        result.append("Luas Permukaan = ").append(String.format("%.2f", kerucut.hitungLuasPermukaanKerucut()));
                        break;
                    case "tigadimen.Kerucut Terpancung":
                        KerucutTerpancung kt = new KerucutTerpancung();
                        kt.setRadiusAtas(params[0]);
                        kt.setRadiusBawah(params[1]);
                        if (params[2] != null) { // Tinggi
                            kt.setTinggiKerucutTerpancung(params[2]);
                        } else if (params[3] != null) { // Sisi Miring
                            kt.setSisiMiringTerpancung(params[3]);
                        } else {
                            throw new IllegalStateException("Tinggi atau Sisi Miring kerucut terpancung harus diatur.");
                        }
                        result.append("Volume = ").append(String.format("%.2f", kt.hitungVolumeFrustum())).append(", ");
                        result.append("Luas Permukaan = ").append(String.format("%.2f", kt.hitungLuasPermukaanFrustum()));
                        break;
                    case "tigadimen.Kubus":
                        Kubus kubus = new Kubus();
                        kubus.setSisi(params[0]);
                        result.append("Volume = ").append(String.format("%.2f", kubus.hitungVolumeKubus())).append(", ");
                        result.append("Luas Permukaan = ").append(String.format("%.2f", kubus.hitungLuasPermukaanKubus()));
                        break;
                    case "Limas Belah Ketupat":
                        LimasBelahKetupat lbk = new LimasBelahKetupat();
                        lbk.setDiagonal1(params[0]);
                        lbk.setDiagonal2(params[1]);
                        lbk.setSisi(params[2]); // For base perimeter
                        lbk.setTinggiLimas(params[3]);
                        result.append("Volume = ").append(String.format("%.2f", lbk.hitungVolumeLimas())).append(", ");
                        result.append("Luas Permukaan = ").append(String.format("%.2f", lbk.hitungLuasPermukaanLimas()));
                        break;
                    case "Limas Jajar Genjang":
                        LimasJajarGenjang ljg = new LimasJajarGenjang();
                        ljg.setAlas(params[0]);
                        ljg.setTinggi(params[1]);
                        ljg.setSisiMiring(params[2]); // For base perimeter
                        ljg.setTinggiLimas(params[3]);
                        result.append("Volume = ").append(String.format("%.2f", ljg.hitungVolumeLimas())).append(", ");
                        result.append("Luas Permukaan = ").append(String.format("%.2f", ljg.hitungLuasPermukaanLimas()));
                        break;
                    case "Limas Layang-Layang":
                        LimasLayangLayang lll = new LimasLayangLayang();
                        lll.setDiagonalHorizontal(params[0]);
                        lll.setDiagonalVertikal(params[1]);
                        lll.setSisiA(params[2]);
                        lll.setSisiB(params[3]);
                        lll.setTinggiLimas(params[4]);
                        result.append("Volume = ").append(String.format("%.2f", lll.hitungVolumeLimas())).append(", ");
                        result.append("Luas Permukaan = ").append(String.format("%.2f", lll.hitungLuasPermukaanLimas()));
                        break;
                    case "Limas duadimen.Persegi":
                        LimasPersegi lp = new LimasPersegi();
                        lp.setSisi(params[0]);
                        lp.setTinggiLimas(params[1]);
                        result.append("Volume = ").append(String.format("%.2f", lp.hitungVolumeLimas())).append(", ");
                        result.append("Luas Permukaan = ").append(String.format("%.2f", lp.hitungLuasPermukaanLimas()));
                        break;
                    // Newly added shapes' calculations
                    case "Cincin tigadimen.Bola":
                        CincinBola cb = new CincinBola();
                        cb.setRadiusDalam(params[0]);
                        cb.setRadiusLuar(params[1]);
                        result.append("Volume = ").append(String.format("%.2f", cb.hitungVolumeCincinBola())).append(", ");
                        result.append("Luas Permukaan = ").append(String.format("%.2f", cb.hitungLuasPermukaanCincinBola()));
                        break;
                    case "Limas duadimen.Persegi Panjang":
                        LimasPersegiPanjang lpp = new LimasPersegiPanjang();
                        lpp.setPanjangAlas(params[0]);
                        lpp.setLebarAlas(params[1]);
                        lpp.setTinggiLimas(params[2]);
                        result.append("Volume = ").append(String.format("%.2f", lpp.hitungVolumeLimas())).append(", ");
                        result.append("Luas Permukaan = ").append(String.format("%.2f", lpp.hitungLuasPermukaanLimas()));
                        break;
                    case "Limas duadimen.Segitiga":
                        LimasSegitiga ls = new LimasSegitiga();
                        ls.setAlasSegitigaAlas(params[0]);
                        ls.setTinggiSegitigaAlas(params[1]);
                        ls.setSisi1Alas(params[2]);
                        ls.setSisi2Alas(params[3]);
                        ls.setSisi3Alas(params[4]);
                        ls.setTinggiLimas(params[5]);
                        result.append("Volume = ").append(String.format("%.2f", ls.hitungVolumeLimas())).append(", ");
                        result.append("Luas Permukaan = ").append(String.format("%.2f", ls.hitungLuasPermukaanLimas()));
                        break;
                    case "Limas duadimen.Trapesium":
                        LimasTrapesium lt = new LimasTrapesium();
                        lt.setSisiAtasAlas(params[0]);
                        lt.setSisiBawahAlas(params[1]);
                        lt.setTinggiTrapesiumAlas(params[2]);
                        lt.setSisiMiring1Alas(params[3]);
                        lt.setSisiMiring2Alas(params[4]);
                        lt.setTinggiLimas(params[5]);
                        result.append("Volume = ").append(String.format("%.2f", lt.hitungVolumeLimas())).append(", ");
                        result.append("Luas Permukaan = ").append(String.format("%.2f", lt.hitungLuasPermukaanLimas()));
                        break;
                    case "Prisma Jajar Genjang":
                        PrismaJajarGenjang pjg = new PrismaJajarGenjang();
                        pjg.setAlasJajarGenjang(params[0]);
                        pjg.setTinggiJajarGenjangAlas(params[1]);
                        pjg.setSisiMiringAlas(params[2]);
                        pjg.setTinggiPrisma(params[3]);
                        result.append("Volume = ").append(String.format("%.2f", pjg.hitungVolume())).append(", ");
                        result.append("Luas Permukaan = ").append(String.format("%.2f", pjg.hitungLuasPermukaan()));
                        break;
                    case "Prisma duadimen.Segitiga":
                        PrismaSegitiga ps = new PrismaSegitiga();
                        ps.setAlasSegitigaAlas(params[0]);
                        ps.setTinggiSegitigaAlas(params[1]);
                        ps.setSisi1Alas(params[2]);
                        ps.setSisi2Alas(params[3]);
                        ps.setSisi3Alas(params[4]);
                        ps.setTinggiPrisma(params[5]);
                        result.append("Volume = ").append(String.format("%.2f", ps.hitungVolume())).append(", ");
                        result.append("Luas Permukaan = ").append(String.format("%.2f", ps.hitungLuasPermukaan()));
                        break;
                    case "Prisma duadimen.Trapesium":
                        PrismaTrapesium pt = new PrismaTrapesium();
                        pt.setSisiAtasAlas(params[0]);
                        pt.setSisiBawahAlas(params[1]);
                        pt.setTinggiTrapesiumAlas(params[2]);
                        pt.setSisiMiring1Alas(params[3]);
                        pt.setSisiMiring2Alas(params[4]);
                        pt.setTinggiPrisma(params[5]);
                        result.append("Volume = ").append(String.format("%.2f", pt.hitungVolume())).append(", ");
                        result.append("Luas Permukaan = ").append(String.format("%.2f", pt.hitungLuasPermukaan()));
                        break;
                    default:
                        result.append("Bentuk tidak dikenal.");
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                // Catch validation errors and calculation errors
                return "Error: " + e.getMessage();
            } catch (Exception e) {
                // Catch any other unexpected errors
                e.printStackTrace();
                return "Error tak terduga: " + e.getMessage();
            }
            return result.toString();
        }

        @Override
        protected void done() {
            // Update the GUI on the Event Dispatch Thread (EDT)
            try {
                resultLabel.setText(get());
            } catch (InterruptedException | ExecutionException ex) {
                resultLabel.setText("Error saat mengambil hasil: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // Ensure GUI updates are done on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainGeometryApp().setVisible(true);
            }
        });
    }
}