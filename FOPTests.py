import unittest
from unittest import TestCase
import pytest
import http_requests

""" Assume this is a FOP web service that accepts posts for username strings, returns 200's for successful names, and a JSON result for failures """


webapp_endpoint = "www.fop.com"

username = {"username1": "Tim Martin Barksdale",
            "username2": "Joe Smith Jr.",
            "username3": "Bill Johnson III",
            "username4": "Zhaozhang Böö",
            "username5": "Billy-Rae Jackson",
            "username6": "Prince",
            "username7": "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefgh",
            "username8": "Z",
            "username9": "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghi",
            "username10": "Tim2 Bar0ksdal3"}

@pytest.fixture()
def url_http():
    return host('webapp_endpoint', scheme='http')

@pytest.fixture()
def assert_equal(is_value, expect_value):
        assert is_value == expect_value, str(is_value) + " != " + str(expect_value)

@pytest.fixture()
def expect_ok(response):
    assert response.status_code == 200, "Response status_code {0} != 200\nResponse reason: {1}\nResponse text: {2}".format(
        str(response.status_code), response.reason.encode('utf-8'), response.text.encode('utf-8'))

class FOPTests(unittest.TestCase):
    """
    All tests in this class
    """
    def test1_three_part_name(self):
        """
        Navigate to a web page
        """
        response = http_requests.get(url_http(), allow_redirects=True)
        expect_ok(response)
        assert "Welcome to FOP" in response.text

        username['username1'] = self.username[0]
        response = http_requests.post(url_http() + "username", headers=None, data=username)
        assert response.json()["is_successful"], response.json()

    def test2_name_w_JR(self):
        """
        Navigate to a web page
        """
        response = http_requests.get(url_http(), allow_redirects=True)
        expect_ok(response)
        assert "Welcome to FOP" in response.text

        username['username2'] = self.username[1]
        response = http_requests.post(url_http() + "username", headers=None, data=username)
        assert response.json()["is_successful"], response.json()

    def test3_name_with_a_third(self):
            """
            Navigate to a web page
            """
            response = http_requests.get(url_http(), allow_redirects=True)
            expect_ok(response)
            assert "Welcome to FOP" in response.text

            username['username3'] = self.username[2]
            response = http_requests.post(url_http() + "username", headers=None, data=username)
            assert response.json()["is_successful"], response.json()

    def test4_name_with_ext_char(self):
            """
            Navigate to a web page
            """
            response = http_requests.get(url_http(), allow_redirects=True)
            expect_ok(response)
            assert "Welcome to FOP" in response.text

            username['username4'] = self.username[3]
            response = http_requests.post(url_http() + "username", headers=None, data=username)
            assert response.json()["is_successful"], response.json()

    def test5_name_with_a_dash(self):
            """
            Navigate to a web page
            """
            response = http_requests.get(url_http(), allow_redirects=True)
            expect_ok(response)
            assert "Welcome to FOP" in response.text

            username['username5'] = self.username[4]
            response = http_requests.post(url_http() + "username", headers=None, data=username)
            assert response.json()["is_successful"], response.json()

    def test6_name_with_a_single_word(self):
            """
            Navigate to a web page
            """
            response = http_requests.get(url_http(), allow_redirects=True)
            expect_ok(response)
            assert "Welcome to FOP" in response.text

            username['username6'] = self.username[5]
            response = http_requests.post(url_http() + "username", headers=None, data=username)
            assert response.json()["is_successful"], response.json()

    def test7_name_with_max_stringlength128(self):
            """
            Navigate to a web page
            """
            response = http_requests.get(url_http(), allow_redirects=True)
            expect_ok(response)
            assert "Welcome to FOP" in response.text

            username['username7'] = self.username[6]
            response = http_requests.post(url_http() + "username", headers=None, data=username)
            assert response.json()["is_successful"], response.json()

    def test8_name_with_max_stringlength128_plus_one(self):
            """
            Navigate to a web page
            """
            response = http_requests.get(url_http(), allow_redirects=True)
            expect_ok(response)
            assert "Welcome to FOP" in response.text

            username['username8'] = self.username[7]
            response = http_requests.post(url_http() + "username", headers=None, data=username)
            assert_equal(response.json()['error']['user_help'], 'Invalid username')

    def test9_name_with_blank_username(self):
            """
            Navigate to a web page
            """
            response = http_requests.get(url_http(), allow_redirects=True)
            expect_ok(response)
            assert "Welcome to FOP" in response.text

            username['username9'] = self.username[8]
            response = http_requests.post(url_http() + "username", headers=None, data=username)
            assert_equal(response.json()['error']['user_help'], 'Invalid username')

    def test10_name_with_alphanumeric(self):
            """
            Navigate to a web page
            """
            response = http_requests.get(url_http(), allow_redirects=True)
            expect_ok(response)
            assert "Welcome to FOP" in response.text

            username['username10'] = self.username[9]
            response = http_requests.post(url_http() + "username", headers=None, data=username)
            assert_equal(response.json()['error']['user_help'], 'Invalid username')
