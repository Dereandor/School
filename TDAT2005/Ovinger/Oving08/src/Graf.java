import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Graf {
    int N;
    int K;
    Node[] node;

    public void initforgj(Node s) {
        for (int i = N; i-->0;) {
            node[i].d = new Forgj();
        }
        ((Forgj)s.d).dist = 0;
    }

    public void ny_vgraf(String filnavn) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filnavn));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        node = new Node[N];
        for (int i = 0; i < N; i++) {
            node[i] = new Node();
        }
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int fra = Integer.parseInt(st.nextToken());
            int til = Integer.parseInt(st.nextToken());
            int vekt = Integer.parseInt(st.nextToken());
            VKant k = new VKant(node[til], (VKant)node[fra].kant1, vekt);
            node[fra].kant1 = k;
        }
    }

    public void bfs(Node s) {
        initforgj(s);
        Queue queue = new Queue(N - 1);
        queue.addQueue(s);
        while (!queue.empty()) {
            Node n = (Node) queue.nextQueue();
            for (Kant k = n.kant1; k != null; k = k.neste) {
                Forgj f = (Forgj) k.til.d;
                if (f.dist == f.uendelig) {
                    f.dist = ((Forgj) n.d).dist + 1;
                    f.forgj = n;
                    queue.addQueue(k.til);
                }
            }
        }
    }
}
