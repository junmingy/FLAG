from __future__ import print_function

import math

from IPython import display
from matplotlib import cm
from matplotlib import gridspec
from matplotlib import pyplot as plt

import numpy as np
import pandas as pd

from sklearn import metrics
import tensorflow as tf
from tensorflow.python.data import Dataset

tf.logging.set_verbosity(tf.logging.ERROR)
pd.options.display.max_rows = 10
pd.options.display.float_format = '{:.1f}'.format

california_housing_dataframe = pd.read_csv("california_housing_train.csv", sep=",")

california_housing_dataframe = california_housing_dataframe.reindex(
    np.random.permutation(california_housing_dataframe.index)
)

def preprocess_features(california_housing_dataframe):
    """
    Prepares input feature from California housing data set
    :param california_housing_dataframe: A Pandas DataFrame expected to contain data
                                         from the California housing data set
    :return: A DataFrame that contains the features to be used for the model,
             including synthetic features
    """
    selected_features = california_housing_dataframe[
        [
            "latitude",
            "longitude",
            "housing_median_age",
            "total_rooms",
            "total_bedrooms",
            "population",
            "households",
            "median_income"
        ]
    ]

    processed_features = selected_features.copy()

    # Create a synthetic feature
    processed_features["rooms_per_person"] = (
        california_housing_dataframe["total_rooms"] /
        california_housing_dataframe["population"]
    )

    return processed_features


def preprocess_targets(california_housing_dataframe):
    """
    Prepares target feature (i.e., labels) from California housing data set
    :param california_housing_dataframe: A Pandas DataFrame expected to contain data
                                         from the California housing data set
    :return: A DataFrame that contains the target feature
    """

    output_targets = pd.DataFrame()

    # Scale the target to be in units of thousands of dollors
    output_targets["median_house_value"] = (
        california_housing_dataframe["median_house_value"] / 1000.0
    )

    return output_targets
