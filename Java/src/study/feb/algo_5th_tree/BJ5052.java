package study.feb.algo_5th_tree;

//https://loosie.tistory.com/447

import java.io.*;
import java.util.*;

public class BJ5052 {
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

            if (trie.terminal && trie.childNode.isEmpty()) { // 해당 노드가 종료 노드이고 자식 노드가 없다면 자기 자신
                return false;
            }
            return true; // 해당 노드가 종료 노드지만 자식이 있다면 해당 번호는 다른 번호에 포함되는 번호
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            TrieNode trie = new TrieNode();
            boolean isConsistent = true;

            String[] numbers = new String[N];
            for (int i = 0; i < N; i++) {
                String temp = br.readLine().strip();
                trie.insert(temp);
                numbers[i] = temp;
            }

            for (String number : numbers) {
                if (trie.isContained(number)) {
                    isConsistent = false;
                    break;
                }
            }

            System.out.println(isConsistent ? "YES" : "NO");
        }
    }
}