class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        for (String log : logs) {
            String[] parts = log.split(" ", 2);
            if (Character.isDigit(parts[1].charAt(0))) {
                digitLogs.add(log); // it's a digit-log
            } else {
                letterLogs.add(log); // it's a letter-log
            }
        }

        // Sort letter logs by content, then by identifier
        Collections.sort(letterLogs, (a, b) -> {
            String[] aParts = a.split(" ", 2);
            String[] bParts = b.split(" ", 2);
            int cmp = aParts[1].compareTo(bParts[1]); // compare content
            if (cmp != 0) return cmp;
            return aParts[0].compareTo(bParts[0]); // if content same, compare ID
        });

        // Combine letterLogs + digitLogs
        letterLogs.addAll(digitLogs);
        return letterLogs.toArray(new String[0]);
    }
}