package codewars;

public class User {

  public int rank = -8;
  public int progress = 0;

  public void incProgress(int activityRank) {
    // Check for illegal values
    if(activityRank < -8 || activityRank > 8 || activityRank == 0) {
      throw new IllegalArgumentException("Invalid activity rank " + activityRank);
    }

    // Don't progress past rank 8
    if(rank == 8) return;

    // Update progress
    if(activityRank == rank) {
      progress += 3;
    } else if(activityRank == rank - 1 || (rank == 1 && activityRank == -1)) {
      progress += 1;
    } else if(activityRank >= rank + 1) {
      int d = activityRank - rank;
      if(rank <= -1 && activityRank >= 1) {
        d--;
      }
      progress += 10 * d * d;
    }

    // Update rank
    while(progress >= 100) {
      rank++;
      if(rank == 0) {
        rank = 1;
      }
      if(rank == 8) {
        progress = 0;
      } else {
        progress -= 100;
      }
    }
  }

}
