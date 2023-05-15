// axios
const posts = [
    { id: 1, title: '제목1', content: '내용1', createdAt: '2021-02-11' },
    { id: 2, title: '제목2', content: '내용2', createdAt: '2023-02-01' },
    { id: 3, title: '제목3', content: '내용3', createdAt: '2023-03-01' },
    { id: 4, title: '제목4', content: '내용4', createdAt: '2023-04-01' },
    { id: 5, title: '제목5', content: '내용5', createdAt: '2023-05-01' },
    { id: 6, title: '제목6', content: '내용6', createdAt: '2023-06-01' },
    { id: 7, title: '제목7', content: '내용7', createdAt: '2023-07-01' }
];

export function getPosts() {
    return posts;
}
