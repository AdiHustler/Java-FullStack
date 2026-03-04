public class StringCompressor {
    public static String compressString(String s) {
        if (s == null || s.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int count = 1;
            // Count consecutive characters
            while (i + 1 < n && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }
            // Append character and count
            sb.append(s.charAt(i)).append(count);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(compressString("aaabbcccc"));
    }
}
