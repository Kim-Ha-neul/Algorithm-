import java.util.Stack;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < moves.length; i++) {
			int index = moves[i] - 1;
			int doll = -1;
			for (int j = 0; j < board.length; j++) {
				if (board[j][index] != 0) {
					if (!stack.isEmpty() && stack.peek() == board[j][index]) {
						answer += 2;
						stack.pop();
					} else
						stack.add(board[j][index]);
					board[j][index] = 0;
					break;
				}
			}
		}

		return answer;
    }
}