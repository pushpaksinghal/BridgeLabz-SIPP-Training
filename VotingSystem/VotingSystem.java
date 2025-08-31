package VotingSystem;

import java.io.*;
import java.util.*;

public class VotingSystem {
    private final HashMap<String, Integer> voteCount = new HashMap<>();
    private final LinkedHashMap<Integer, String> voteOrder = new LinkedHashMap<>();
    private final List<String> candidates = Arrays.asList("Narendra Modi", "Rahul Gandhi");
    private int voteId = 0;

    public void castVote(String inputCandidate) {
        for (String candidate : candidates) {
            if (candidate.equalsIgnoreCase(inputCandidate)) {
                voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
                voteOrder.put(++voteId, candidate);
                System.out.println("✅ Vote cast for " + candidate);
                return;
            }
        }
        System.out.println("❌ Invalid candidate: " + inputCandidate);
    }

    public void showCandidates() {
        System.out.println("\nCandidates:");
        for (int i = 0; i < candidates.size(); i++) {
            System.out.println((i + 1) + ". " + candidates.get(i));
        }
        System.out.println("3. Exit Voting");
    }

    public void displayVoteOrder() {
        System.out.println("\nVote Order (LinkedHashMap):");
        for (Map.Entry<Integer, String> entry : voteOrder.entrySet()) {
            System.out.println("Vote#" + entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void displayRawVotes() {
        System.out.println("\nVote Count (HashMap):");
        for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public void displaySortedResults() {
        TreeMap<String, Integer> sortedVotes = new TreeMap<>(voteCount);
        System.out.println("\nSorted Results:");

        int highestVotes = 0;
        List<String> topCandidates = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : sortedVotes.entrySet()) {
            String candidate = entry.getKey();
            int votes = entry.getValue();

            System.out.println(candidate + " : " + votes);

            if (votes > highestVotes) {
                highestVotes = votes;
                topCandidates.clear();
                topCandidates.add(candidate);
            } else if (votes == highestVotes) {
                topCandidates.add(candidate);
            }
        }

        System.out.println("\nTotal Votes Cast: " + voteId);

        if (topCandidates.size() == 1) {
            System.out.println("\n\u001B[32mWinner : " + topCandidates.get(0) + "\u001B[0m");
        } else {
            System.out.println("\nDRAW between: " + topCandidates);
        }
    }

    public static void main(String[] args) throws IOException {
        VotingSystem vs = new VotingSystem();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            vs.showCandidates();
            System.out.print("\nEnter option (1, 2 or 3): ");
            String input = reader.readLine().trim();

            if (input.equals("3")) break;

            switch (input) {
                case "1":
                    vs.castVote("Narendra Modi");
                    break;
                case "2":
                    vs.castVote("Rahul Gandhi");
                    break;
                default:
                    System.err.println("⚠️ Invalid input, try again.\n");
            }
        }

        vs.displayVoteOrder();
        vs.displayRawVotes();
        vs.displaySortedResults();
    }
}
