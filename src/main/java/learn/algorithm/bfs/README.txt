BFS算法按照距离开始状态由近及远的顺序搜索，因此一般用于求解最短路径、最少操作之类问题。
（将已经访问过的状态用标记管理起来）

1、Maze类:
    问题:迷宫最短路径（bfs）
    描述:给定一个大小为N X M的迷宫。迷宫由通道和墙壁组成，每一步可以向邻接的上下左右四格移动。求：从起点到终点所需要的最小步数。
    输入:
N=10,M=10
#S######.#
......#..#
.#.##.##.#
.#........
##.##.####
....#....#
.#######.#
....#.....
.####.###.
....#...G#
    输出: 22
    说明：‘#’，‘.’，‘S’,'G'分别代表墙壁、通道、起点和终点
