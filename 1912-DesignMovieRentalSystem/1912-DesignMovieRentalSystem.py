# Last updated: 9/20/2025, 11:42:24 PM
class MovieRentingSystem:

    def __init__(self, n: int, entries: List[List[int]]):
        self.shops = {}
        self.movies = {}
        self.rented = SortedList()
        for shop, movie, price in entries:
            self.shops[(shop, movie)] = price
            if self.movies.get(movie) is None:
                self.movies[movie] = SortedList()
            self.movies.get(movie).add((price, shop))
        # print("shops: ", self.shops)
        # print("movies: ", self.movies)
        # print("rented: ", self.rented)

    def search(self, movie: int) -> List[int]:
        lst = self.movies.get(movie)
        if lst is None:
            lst = []
        res = []
        for i in range(min(5, len(lst))):
            res.append(lst[i][1])
        return res
        

    def rent(self, shop: int, movie: int) -> None:
        price = self.shops[(shop, movie)]
        #remove it from movie list
        lst = self.movies[movie]
        lst.remove((price, shop))

        #put it to rented
        self.rented.add((price, shop, movie))

    def drop(self, shop: int, movie: int) -> None:
        price = self.shops[(shop, movie)]
        #remove it from movie list
        lst = self.movies[movie]
        lst.add((price, shop))

        #put it to rented
        self.rented.remove((price, shop, movie))

    def report(self) -> List[List[int]]:
        res = []
        for i in range(min(5, len(self.rented))):
            price, shop, movie = self.rented[i]
            res.append((shop, movie))
        return res
        


# Your MovieRentingSystem object will be instantiated and called as such:
# obj = MovieRentingSystem(n, entries)
# param_1 = obj.search(movie)
# obj.rent(shop,movie)
# obj.drop(shop,movie)
# param_4 = obj.report()