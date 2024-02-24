import java.io.*;
import java.util.*;

public class Main {
    static class TrieNode {
        Map<Character, TrieNode> childNode = new HashMap<>();
        boolean terminal; // 종료 노드인지 표기하는 값

        public void insert(String word) {
            TrieNode trie = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                // childNode에 c없으면 추가
                trie.childNode.putIfAbsent(c, new TrieNode());
                trie = trie.childNode.get(c);
                // 마지막 문자 표시
                if (i == word.length() - 1) {
                    trie.terminal = true;
                    return;
                }
            }
        }

        public boolean isContained(String word) {
            TrieNode trie = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode node = trie.childNode.get(c);

                if (node == null) { // key값이 c라는 childNode가 없다면 해당 단어는 Trie에 포함되지 않음.
                    return false;
                }
                trie = node;
            }

            if (trie.terminal) { // 해당 단어가 존재하는 경우 일관성 x
                if (trie.childNode.isEmpty()) { // 자기 자신 제외(childNode가 없으면 해당 종료노드 자기 자신)
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            TrieNode trie = new TrieNode();
            boolean isContained = true;

            String[] numbers = new String[N];
            for (int i = 0; i < N; i++) {
                String temp = br.readLine().strip();
                trie.insert(temp);
                numbers[i] = temp;
            }

            for (String number : numbers) {
                if (trie.isContained(number)) {
                    isContained = false;
                    break;
                }
            }

            System.out.println(isContained ? "YES" : "NO");
        }
    }
}