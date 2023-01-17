import altair as alt
from vega_datasets import data

source = data.wheat()

alt.Chart(source).mark_bar().encode(
    x='year:O',
    y="wheat:Q",
    color=alt.condition(
        alt.datum.year == 1810,
        alt.value('orange'),
        alt.value('steelblue')
    )
).properties(width=600)
