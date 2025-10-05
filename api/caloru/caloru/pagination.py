from rest_framework.pagination import PageNumberPagination


class CaloruPagination(PageNumberPagination):
    page_size = 10  # default page size
    page_size_query_param = "page_size"
    max_page_size = 100
